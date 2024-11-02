import org.genshin.mapper.Mapper;
import org.genshin.model.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, User> XiaoMainUserMap = new HashMap<>();

        // use akasha json to get an arraylist of all xiao users, then create a user object for each uid in that arraylist, then map all the uids and user objects into the above map
        Integer uid = 809949310;
        User user = Mapper.userMapper("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/809949310.json");
        XiaoMainUserMap.put(uid, user);

        User x = XiaoMainUserMap.get(809949310);
        System.out.println(x.getAvatarInfoList().get(0).getAvatarId());
    }

}
