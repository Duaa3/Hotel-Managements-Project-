package com.HotelManagementsProject.Hotel.Managements.Project.Controller;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Role;
import com.HotelManagementsProject.Hotel.Managements.Project.RoleToUserDTO;

public interface RoleControllerInterface {
    /**
     * Save a new role
     *
     * @param role the role to be saved
     */
    void saveRole(Role role);

    /**
     * Add a role to a user
     *
     * @param roleToUserDTO object containing the username and role name to be added to the user
     */
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
