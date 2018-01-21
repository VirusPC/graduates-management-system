package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestCreateTable {
	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建SchemaExport对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}
}
