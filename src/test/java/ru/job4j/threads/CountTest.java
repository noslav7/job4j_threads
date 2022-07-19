package java.ru.job4j.threads;

import org.junit.jupiter.api.Test;
import ru.job4j.threads.Count;

import static org.assertj.core.api.Assertions.assertThat;

class CountTest {

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        Count count = new Count();
        Thread first = new Thread(count::increment);
        Thread second = new Thread(count::increment);
        /* Запускаем нити. */
        first.start();
        second.start();
        /* Заставляем главную нить дождаться выполнения наших нитей. */
        first.join();
        second.join();
        /* Проверяем результат. */
        assertThat(count.get()).isEqualTo(2);
    }
}