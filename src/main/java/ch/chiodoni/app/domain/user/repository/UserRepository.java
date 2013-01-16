package ch.chiodoni.app.domain.user.repository;

import ch.chiodoni.app.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 26.11.12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
