package br.com.zeng.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtils {

	private static Configuration cfg = new Configuration();

	@SuppressWarnings("rawtypes")
	public static final String parseTemplate(Map map, String templateName, String templatesFolder) throws TemplateException, IOException {
		System.out.println(templatesFolder);
		File templateDirectory = new File(templatesFolder);
		cfg.setDirectoryForTemplateLoading(templateDirectory);
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template template = cfg.getTemplate(templateName);
		StringWriter writer = new StringWriter();
		template.process(map, writer);
		writer.flush();
		writer.close();
		return writer.toString();

	}

}
