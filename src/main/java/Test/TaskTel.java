package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTel {
    private String text;

    public String getText() {
        return text;
    }

    public TaskTel(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TaskTel{" +
                "text='" + text + '\'' +
                '}';
    }

    public static void main(String[] args) {
        TaskTel tt1 = new TaskTel("33");
        TaskTel tt2 = new TaskTel("22");
        TaskTel tt3 = new TaskTel("1");
        TaskTel tt4 = new TaskTel("cc");
        TaskTel tt5 = new TaskTel("z");
        TaskTel tt6 = new TaskTel("f");
        TaskTel tt7 = new TaskTel("55");
        List<TaskTel> aa = new ArrayList<>();
        Collections.addAll(aa, tt1, tt2, tt3, tt4, tt5, tt6, tt7);

        aa = aa.stream()
                .sorted()
                .collect(Collectors.toList());
        aa.stream().forEach(System.out::println);
    }
}