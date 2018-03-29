package org.packt.swarm.petstore.catalog;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;

public class Main {

    public static void main(String[] args) throws Exception {
        DatasourcesFraction datasourcesFraction = new DatasourcesFraction()
                //1
                .jdbcDriver("h2", (d) -> {
                    d.driverClassName("org.h2.Driver");
                    d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
                    d.driverModuleName("com.h2database.h2");
                })
                //2
                .dataSource("CatalogDS", (ds) -> {
                    ds.driverName("h2");
                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
                    ds.userName("sa");
                    ds.password("sa");
                });

        Swarm swarm = new Swarm();
        swarm.fraction(datasourcesFraction);
        swarm.start().deploy();
    }
}