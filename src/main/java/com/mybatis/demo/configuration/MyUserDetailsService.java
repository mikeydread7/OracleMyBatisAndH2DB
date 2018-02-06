/*
 * package com.mybatis.demo.configuration;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * 
 * public final class MyUserDetailsService implements UserDetailsService {
 * private static List<UserObject> users = new ArrayList<UserObject>();
 * 
 * public MyUserDetailsService() { //I will use a Real DB for this in A REAL
 * APPLICATION with security users.add(new UserObject("erin", "123", "ADMIN"));
 * users.add(new UserObject("mike", "234", "ADMIN")); users.add(new
 * UserObject("mike", "345", "USER")); users.add(new UserObject("user",
 * "password", "USER")); }
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Optional<UserObject> user = users.stream()
 * .filter(u -> u.name.equals(username)) .findAny(); if (!user.isPresent()) {
 * throw new UsernameNotFoundException("User not found by name: " + username); }
 * return toUserDetails(user.get()); }
 * 
 * private UserDetails toUserDetails(UserObject userObject) { return
 * User.withUsername(userObject.name) .password(userObject.password)
 * .roles(userObject.role).build(); }
 * 
 * private static class UserObject { private String name; private String
 * password; private String role;
 * 
 * public UserObject(String name, String password, String role) { this.name =
 * name; this.password = password; this.role = role; } } }
 */