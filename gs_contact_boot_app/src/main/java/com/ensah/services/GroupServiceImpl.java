package com.ensah.services;

import com.ensah.bo.Groupe;
import com.ensah.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author FZ.ESSABRI
 */
@Service
@Transactional
public class GroupServiceImpl implements IGroupService{
    private GroupDao groupDao;
    @Autowired
    public GroupServiceImpl(GroupDao gDao){ groupDao = gDao;}
    @Override
    public void addGroup(Groupe group) {
        groupDao.save(group);
    }

    @Override
    public void updateGroup(Groupe group) {
        groupDao.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        groupDao.deleteById(id);
    }

    @Override
    public List<Groupe> getAllGroups() {
        return groupDao.findAll();
    }

    @Override
    public Groupe getGroupByName(String name) {

        return groupDao.getGroupeByGroupeName(name);
    }

    @Override
    public Groupe getGroupById(Long id) {
        return groupDao.findById(id).get();
    }
}
