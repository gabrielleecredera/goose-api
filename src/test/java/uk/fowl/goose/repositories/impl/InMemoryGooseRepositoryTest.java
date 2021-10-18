package uk.fowl.goose.repositories.impl;

import org.junit.jupiter.api.Test;
import uk.fowl.goose.model.GooseInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryGooseRepositoryTest {
    private final InMemoryGooseRepository repository = new InMemoryGooseRepository();

    @Test
    void shouldAssignGooseCorrectId() {
        GooseInfo gerald = new GooseInfo(null, "Gerald", 100);
        Long geraldId = repository.add(gerald);
        assertThat(geraldId).isEqualTo(0);
    }

    @Test
    void shouldStoreAndRetrieveGoose() {
        GooseInfo gerald = new GooseInfo(null, "Gerald", 100);
        long geraldId = repository.add(gerald);
        GooseInfo retrievedGoose = repository.get((int) geraldId);
        assertThat(retrievedGoose).isEqualTo(gerald);
    }

    @Test
    void shouldReturnGeeseWithNameInSearchString() {
        GooseInfo gerald1 = new GooseInfo(null, "Gerald1", 100);
        GooseInfo gerald2 = new GooseInfo(null, "Gerald2", 100);
        long gerald1Id = repository.add(gerald1);
        long gerald2Id = repository.add(gerald2);
        List<GooseInfo> foundGeese = repository.search("1");
        assertThat(foundGeese.size()).isEqualTo(1);
        assertThat(foundGeese.get(0)).isEqualTo(gerald1);
    }
}