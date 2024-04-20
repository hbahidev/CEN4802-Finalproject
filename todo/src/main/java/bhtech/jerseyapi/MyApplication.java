package bhtech.jerseyapi;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class MyApplication extends Application {
    // No need to override any methods unless you want to customize the application
}
