package md.ciocana.service.impl;

import lombok.RequiredArgsConstructor;
import md.ciocana.dao.GroupDAO;
import md.ciocana.model.Group;
import md.ciocana.model.Student;
import md.ciocana.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupDAO groupDAO;

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.getAllGroups();
    }

    @Override
    public void save(Group group) {
        groupDAO.save(group);
    }

    @Override
    public Optional<Group> getGroupById(int groupId) {
        return groupDAO.getGroupById(groupId);
    }
}
