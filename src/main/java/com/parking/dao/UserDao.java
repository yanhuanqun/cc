package com.parking.dao;

import com.parking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User,Integer>,
		JpaSpecificationExecutor<User> {

	/**
	 * find by username
	 * @param username username
	 * @return user
	 * */
	User findUserByUsername(String username);

	/**
	 * find by username and password
	 * @param username username
	 * @param password password
	 * @return user
	 * */
	User findUserByUsernameAndPassword(String username, String password);

	/**
	 * modify info
	 * @param username username
	 * @param phone phone
	 * @return int
	 */
	@Query(value = "UPDATE User set phone = :phone where username = :username")
	@Modifying
	int modifyInfo(@Param("username") String username, @Param("phone") Long phone);

}
