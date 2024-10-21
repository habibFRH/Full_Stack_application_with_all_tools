package firstAppTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;



public class getContainerTest extends AbstractTestContainers {

    @Test
    void canStartPostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();
    }


}
