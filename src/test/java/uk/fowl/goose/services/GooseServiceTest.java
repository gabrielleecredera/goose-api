package uk.fowl.goose.services;

import org.junit.jupiter.api.Test;
import uk.fowl.goose.exceptions.GooseNotFoundException;
import uk.fowl.goose.exceptions.GooseTooAggressiveException;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repositories.GooseRepository;
import uk.fowl.goose.repositories.impl.StubGooseRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GooseServiceTest {
    private final GooseRepository stubGooseRepository = new StubGooseRepository();
    private final GooseService gooseService = new GooseService(stubGooseRepository);

    @Test
    void shouldReturnGooseById() {
        GooseInfo retrievedGoose = gooseService.get(1);
        assertThat(retrievedGoose).isEqualTo(StubGooseRepository.GERALD);
    }

    @Test
    void shouldThrowExceptionIfGooseNotFound() {
        assertThatThrownBy(() -> gooseService.get(5)).isInstanceOf(GooseNotFoundException.class);
    }

    @Test
    void shouldCreateGooseAndReturnId() {
        long gooseId = gooseService.add(new GooseInfo(1L, "goose", 1));
        assertThat(gooseId).isEqualTo(1L);
    }

    @Test
    void shouldThrowExceptionIfGooseTooAggressive() {
        assertThatThrownBy(() -> gooseService.add(new GooseInfo(1L, "goose", 100000000))).isInstanceOf(GooseTooAggressiveException.class);
    }
}