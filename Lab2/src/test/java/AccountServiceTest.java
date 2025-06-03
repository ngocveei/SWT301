import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

import vyttn.AccountService;

public class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Test
    @DisplayName("Valid account registration returns true")
    void testValidRegister() {
        boolean result = accountService.registerAccount("john", "password123", "john@mail.com");
        assertTrue(result);
    }

    @ParameterizedTest(name = "Test {index} - username={0}, password={1}, email={2} => expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Parameterized - registerAccount with various inputs")
    void testRegisterVariousInputs(String username, String password, String email, boolean expected) {
        boolean result = accountService.registerAccount(username, password, email);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Email validation returns false for invalid emails")
    void testInvalidEmail() {
        assertFalse(accountService.isValidEmail("invalid_email"));
    }

    @Test
    @DisplayName("generateWelcomeMessage returns correct greeting")
    void testGenerateWelcomeMessage() {
        String msg = accountService.generateWelcomeMessage("Alice");
        assertEquals("Welcome, Alice!", msg);
    }
}
