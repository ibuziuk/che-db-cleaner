package io.developer.sandbox.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

@Singleton
public class WorkspaceConfig {
    private static final Logger LOG = Logger.getLogger(WorkspaceConfig.class);
    private static final String DELETE_FROM_WORKSPACE_CONFIG = "DELETE FROM workspaceconfig WHERE id = ?";

    @Inject
    DataSource dataSource;

    public void delete(final String id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            LOG.info("Connection has been obtained for: " + WorkspaceConfig.class);
            try (PreparedStatement deleteFromWorkspaceConfig = connection
                    .prepareStatement(DELETE_FROM_WORKSPACE_CONFIG)) {
                deleteFromWorkspaceConfig.setString(1, id);
                deleteFromWorkspaceConfig.execute();
            }
        }
    }
}
