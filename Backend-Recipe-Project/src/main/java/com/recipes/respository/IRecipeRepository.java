package com.recipes.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipes.entities.Recipe;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe,Integer> {

	Optional<Recipe> findByName(String name);
	
//	 @Query("SELECT r from Recipe WHERE r.name=:name")
//	public Optional<Recipe> findByName(@Param("name") String Name);
//   
}
