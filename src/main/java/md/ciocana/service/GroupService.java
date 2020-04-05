package md.ciocana.service;

import md.ciocana.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> getAllGroups();
    void save(Group group);
    Optional<Group> getGroupById(int groupId);
}
