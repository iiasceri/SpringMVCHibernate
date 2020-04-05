package md.ciocana.dao.impl;

import lombok.RequiredArgsConstructor;
import md.ciocana.dao.GroupDAO;
import md.ciocana.model.Group;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Component
public class GroupDAOImpl implements GroupDAO {
    private final SessionFactory sessionFactory;

    @Override
    public List<Group> getAllGroups() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT group FROM Group group", Group.class)
                .getResultList();
    }

    @Override
    public void save(Group group) {
        sessionFactory.getCurrentSession().save(group);
    }

    @Override
    public Optional<Group> getGroupById(int groupId) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT group FROM Group group WHERE group.groupId = :gId", Group.class)
                .setParameter("gId", groupId)
                .getResultList().stream().findFirst();
    }
}
