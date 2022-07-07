package operation;

import util.FileUtil;

public class DeleteOperation {

    public void deleteById(String id) {
        FileUtil.deleteFromFileById(id);
    }
}
