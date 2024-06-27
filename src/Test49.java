import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test49 {
    /**
     * 将字母异位词分组。
     * @param strs 给定的字符串数组
     * @return 分组后的字母异位词列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，用于存储排序后的字符串作为键，对应的原始字符串列表作为值
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // 遍历字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组
            char[] array = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(array);
            // 将排序后的字符数组重新组合成字符串，作为哈希表的键
            String key = new String(array);
            // 获取哈希表中对应键的字符串列表，如果不存在则创建一个新的列表
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            // 将原始字符串添加到列表中
            list.add(str);
            // 将更新后的列表重新存入哈希表
            map.put(key, list);
        }

        // 将哈希表中的所有列表收集到一个新的列表中，并返回
        return new ArrayList<List<String>>(map.values());
    }
}