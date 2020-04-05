package md.ciocana.dao;

import md.ciocana.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupDAO {
    List<Group> getAllGroups();
    void save(Group group);
    Optional<Group> getGroupById(int groupId);
}
