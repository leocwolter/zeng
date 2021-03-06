package br.com.zeng.serialization;

import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;

public class PersistentBagConverter extends CollectionConverter {

	public PersistentBagConverter(XStream xstream) {
		super(xstream.getMapper());
	}
	
	@Override @SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return Collection.class.isAssignableFrom(type);
	}
}
