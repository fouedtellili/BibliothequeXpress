package com.example.bibliothequexpress.serviceImpl;

import com.example.bibliothequexpress.model.Role;
import com.example.bibliothequexpress.repository.RoleRepository;
import com.example.bibliothequexpress.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    public Role addRole(Role role){
        return roleRepository.save(role);
    }
}
