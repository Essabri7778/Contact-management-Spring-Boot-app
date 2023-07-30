package com.ensah.services;

import com.ensah.bo.Groupe;

import java.util.List;

/**
 * @author FZ.ESSABRI
 */
public interface IGroupService {

    public void addGroup(Groupe group);
    public void updateGroup(Groupe group);
    public void deleteGroup(Long id);
    public List<Groupe> getAllGroups();
    public Groupe getGroupByName(String name);
    public Groupe getGroupById(Long id);
}
