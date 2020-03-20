package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entities.Status;

/*@author Akansha Shah
@Creation_date 12/02/2020 12:30PM
@Modification_date 12/02/2020 12:30PM
@copyright Zensar technologies. All rights reserved.
@version 2.0
*/
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
