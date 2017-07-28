package common
/**
 * Created by VErmilov on 27.02.2017.
 */
class EnumUtil {
    public static List<String> getNames(Class<? extends Enum<?>> e) {
        return Arrays.asList(e.getEnumConstants().replaceAll("^.|.\$", "").split(", "))
    }

}
