package com.restful;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Spring Data (JPA + REST)
 * RepositoryRestResource: 资源路径
 * RestResource: 搜索路径
 *
 * @author agony
 * @date 2020/4/21 22:39
 */
@CrossOrigin
@RepositoryRestResource(path = "bs" , collectionResourceRel = "bs", itemResourceRel = "b")
public interface BookRepository extends JpaRepository<Book, Long> {
    @RestResource(path = "author", rel = "author")
    List<Book> findByAuthorContains(@Param("author") String author);

    @RestResource(path = "name", rel = "name")
    Book findByNameEquals(@Param("name") String name);
}
