package blr.tg.rcc.r3.a;

/**
 * Петя разрабатывает собственный редактор электронных таблиц. В его редакторе столбцы будут называться следующим образом:
 * первые 26 столбцов — соответствующими буквами латинского алфавита: A, B, C, ..., Z.
 * Следующие столбцы, начиная с 27, называются парами букв: AA, AB, ..., AZ, BA, BB, ..., BZ, ..., ZZ.
 * Далее используются тройки букв: AAA, AAB, AAC, ..., затем четверки, и так далее.
 * <p>
 * Теперь Пете необходимо по номеру столбца определить его название. Помогите ему написать соответствующий фрагмент кода.
 * <p>
 * Формат входных данных
 * Входные данные содержат несколько тестовых примеров. Первая строка содержит целое число t — количество тестов (1 ≤ t ≤ 1000).
 * <p>
 * Следующие t строк содержат по одному целому число k (1 ≤ k ≤ 109).
 * <p>
 * Формат выходных данных
 * Для каждого теста выведите в отдельной строке название k-го столбца.
 * Входные данные
 * 4
 * 1
 * 10
 * 100
 * 1000
 * Выходные данные
 * A
 * J
 * CV
 * ALL
 * Created by Uleychik_SA on 04.05.2017.
 */
public class ExcelKiller {

    private static final int ALPHA_LEN = 26;
    private static final char ALPHA[] = new char[ALPHA_LEN];

    static {
        for (int i = 0; i < ALPHA_LEN; i++) {
            ALPHA[i] = (char) ('A' + i);
        }
    }

    public String getColNameByNumber(int num) {

        StringBuilder sb = new StringBuilder();
        int offset;
        do {
            num--;
            offset = num % ALPHA_LEN;
            num /= ALPHA_LEN;
            sb.append(ALPHA[offset]);
        } while (num > 0);

        return sb.reverse().toString();
    }


}
