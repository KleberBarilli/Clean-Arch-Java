import br.com.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    void shouldNotBeAbleToCreateAnInvalidMail() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalidMail.com"));
    }


}
