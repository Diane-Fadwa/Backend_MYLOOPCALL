//package com.fadwa.myloopcall.config;
//
//import com.fadwa.myloopcall.entity.RoleEntity;
//import com.fadwa.myloopcall.entity.UserEntity;
//import com.fadwa.myloopcall.repository.RoleRepository;
//import com.fadwa.myloopcall.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class DataInitializer implements CommandLineRunner {
//
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    private static final String[] AVAILABLE_PAGES = {
//            "Tableau de bord",
//            "Clients",
//            "Commercial",
//            "Prospects",
//            "Utilitaires",
//            "Rapports",
//            "Paramètres"
//    };
//
////    @Override
////    public void run(String... args) {
////        initializeRoles();
////        initializeAdminUser();
////    }
//
//    private void initializeRoles() {
//        // Admin Role - Full access
//        if (!roleRepository.existsByNom("ADMIN")) {
//            RoleEntity adminRole = new RoleEntity();
//            adminRole.setNom("ADMIN");
//            adminRole.setDescription("Administrateur avec accès complet");
//
//            Set<RoleEntity.Permission> adminPermissions = new HashSet<>();
//            for (String page : AVAILABLE_PAGES) {
//                RoleEntity.Permission permission = new RoleEntity.Permission();
//                permission.setPage(page);
//                permission.setCanView(true);
//                permission.setCanEdit(true);
//                adminPermissions.add(permission);
//            }
//            adminRole.setPermissions(adminPermissions);
//
//            roleRepository.save(adminRole);
//            log.info("Admin role created successfully");
//        }
//
//        // Client Role - Limited access
//        if (!roleRepository.existsByNom("CLIENT")) {
//            RoleEntity clientRole = new RoleEntity();
//            clientRole.setNom("CLIENT");
//            clientRole.setDescription("Client avec accès limité");
//
//            Set<RoleEntity.Permission> clientPermissions = new HashSet<>();
//
//            // Dashboard - Read only
//            RoleEntity.Permission dashboardPerm = new RoleEntity.Permission();
//            dashboardPerm.setPage("Tableau de bord");
//            dashboardPerm.setCanView(true);
//            dashboardPerm.setCanEdit(false);
//            clientPermissions.add(dashboardPerm);
//
//            // Prospects - Read only
//            RoleEntity.Permission prospectsPerm = new RoleEntity.Permission();
//            prospectsPerm.setPage("Prospects");
//            prospectsPerm.setCanView(true);
//            prospectsPerm.setCanEdit(false);
//            clientPermissions.add(prospectsPerm);
//
//            clientRole.setPermissions(clientPermissions);
//
//            roleRepository.save(clientRole);
//            log.info("Client role created successfully");
//        }
//    }
//
////    private void initializeAdminUser() {
////        if (!userRepository.existsByUsername("admin")) {
////            RoleEntity adminRole = roleRepository.findByNom("ADMIN")
////                    .orElseThrow(() -> new RuntimeException("Admin role not found"));
////
////            UserEntity adminUser = new UserEntity();
////            adminUser.setUsername("admin");
////            adminUser.setEmail("admin@myloopcall.com");
////            adminUser.setPassword(passwordEncoder.encode("Admin@123"));
////            adminUser.setNom("Administrateur");
////            adminUser.setPrenom("Système");
////            adminUser.setRole(adminRole);
////            adminUser.setActif(true);
////
////            userRepository.save(adminUser);
////            log.info("Admin user created successfully - Username: admin, Password: Admin@123");
////        }
//  //  }
//}