package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V2__Insert_initial_workation_data extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        // Load CSV from resources
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/workations.csv")))) {
            // Skip the header line
            String line = reader.readLine();

            // Read each line and insert into DB
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                try (PreparedStatement stmt = context.getConnection().prepareStatement(
                        "INSERT INTO workation (workation_id, employee, origin, destination, start_date, end_date, working_days, risk) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

                    stmt.setString(1, fields[0].trim());
                    stmt.setString(2, fields[1].trim());
                    stmt.setString(3, fields[2].trim());
                    stmt.setString(4, fields[3].trim());
                    stmt.setString(5, fields[4].trim());
                    stmt.setString(6, fields[5].trim());
                    stmt.setInt(7, Integer.parseInt(fields[6].trim()));
                    stmt.setString(8, fields[7].trim());

                    stmt.executeUpdate();
                }
            }
        }
    }
}