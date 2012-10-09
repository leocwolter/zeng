package br.com.zeng.serialization;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.serialization.ProxyInitializer;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilder;
import br.com.caelum.vraptor.serialization.xstream.XStreamJSONSerialization;

import com.thoughtworks.xstream.XStream;

@Component
public class CustomJSONSerialization extends XStreamJSONSerialization {

  public CustomJSONSerialization(HttpServletResponse response, TypeNameExtractor extractor, ProxyInitializer initializer, XStreamBuilder builder) {
    super(response, extractor, initializer, builder);
  }

  @Override
  protected XStream getXStream() {
    XStream xstream = super.builder.jsonInstance();
    xstream.registerConverter(new PersistentBagConverter(xstream));
    return xstream;
  }

}