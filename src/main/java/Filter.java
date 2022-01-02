import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = source.stream()
                .filter(number -> {
                    boolean matcher = number >= threshold;
                    if (matcher) {
                        logger.log("Элемент " + number + " проходит");
                    } else {
                        logger.log("Элемент " + number + " не проходит");
                    }
                    return matcher;
                }).collect(Collectors.toList());
        logger.log("Прошло фильтр " + result.size() + " из " + source.size());

        return result;
    }
}
