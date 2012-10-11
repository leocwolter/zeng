package br.com.zeng.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.joda.time.DateTime;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.chart.UserTasksPerMonth;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.User;

@Component
public class TaskDao {
	private static final int MANY_TASKS = 10;
	private final Session session;

	public TaskDao(Session session) {
		this.session = session;
	}

	public void insert(Task task) {
		session.save(task);
	}

	public Task getTaskWithId(Long id) {
		return (Task) session.get(Task.class, id);
	}

	public void update(Task task) {
		session.update(task);
	}

	public void archive(Task task) {
		task.setArchived(true);
		update(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasksWithContentInAProject(String content, Project project){
		List<Task> tasks = session.createQuery("from Task t where t.name like :content or t.description like :content and t.taskList.category.project.url like :project")
							.setString("content", "%"+content+"%")
							.setString("project", project.getUrl())
							.list();
		return tasks;
	}

	@SuppressWarnings("unchecked")
	public boolean manyTasksWithSameExpirationDate(Project project) {
		List<Long> list = session.createQuery("select count(*) from Task t where t.expirationDate != null and t.taskList.category.project.url like :project and t.state != 2 and t.archived = 0 group by year(t.expirationDate),month(t.expirationDate)")
								.setString("project", project.getUrl())
								.list();
		for (Long numberOfTasks : list) {
			if(numberOfTasks>=MANY_TASKS) return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserTasksPerMonth> getQuantityOfTasksGroupedByDateAndUser(Project project){
		List<Object[]> list = session.createQuery("select year(t.dateOfCompletion), month(t.dateOfCompletion), c.id, count(*) from Task t join t.contributors c where t.dateOfCompletion != null and t.taskList.category.project.url like :project and t.state=2 group by year(t.dateOfCompletion),month(t.dateOfCompletion), c.id order by c.id")
								.setString("project", project.getUrl())
								.list();
		return buildUsersTasksPerMonthList(list);
	}

	private ArrayList<UserTasksPerMonth> buildUsersTasksPerMonthList(List<Object[]> list) {
		HashMap<User, UserTasksPerMonth> tasksPerMonthPerUser = groupByUser(list);
		ArrayList<UserTasksPerMonth> usersTasksPerMonthList = new ArrayList<UserTasksPerMonth>();
		usersTasksPerMonthList.addAll(tasksPerMonthPerUser.values());
		return usersTasksPerMonthList;
	}

	private HashMap<User, UserTasksPerMonth> groupByUser(	List<Object[]> list) {
		HashMap<User,UserTasksPerMonth> tasksPerMonthPerUser = new HashMap<User, UserTasksPerMonth>();
		for (Object[] object : list) {
			putOrAdd(tasksPerMonthPerUser, object);
		}
		return tasksPerMonthPerUser;
	}

	private void putOrAdd(HashMap<User, UserTasksPerMonth> tasksPerMonthPerUser, Object[] object) {
		DateTime dateTime = new DateTime((Integer)object[0],(Integer)object[1],1,0,0,0,0);
		User user = (User) session.get(User.class, (Long)object[2]);
		Long count = (Long) object[3];
		if(tasksPerMonthPerUser.containsKey(user)){
			tasksPerMonthPerUser.get(user).addQuantityOfTasksPerMonth(dateTime, count);
		}else{
			HashMap<DateTime, Long> quantityOfTasksPerMonth = new HashMap<DateTime, Long>();
			quantityOfTasksPerMonth.put(dateTime, count);
			UserTasksPerMonth userTasksPerMonth = new UserTasksPerMonth(user, quantityOfTasksPerMonth);
			tasksPerMonthPerUser.put(user, userTasksPerMonth);
		}
	}

	public void finalize(Task task) {
		task.finalize();
		update(task);
	}

	public void start(Task task) {
		task.start();
		update(task);
	}

	public void stop(Task task) {
		task.stop();
		update(task);
	}

}
