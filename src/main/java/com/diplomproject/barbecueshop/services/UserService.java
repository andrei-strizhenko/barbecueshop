package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.dto.LoginDto;
import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService extends GenericService<User> {

    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
 //   private final JavaMailSender javaMailSender;

    protected UserService(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService /*, JavaMailSender javaMailSender*/) {
        super(repository);
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
     //   this.javaMailSender = javaMailSender;
    }

    @Override
    public User create(User user) {
  //      user.setCreatedBy("REGISTRATION");
        user.setRole(roleService.getOne(1L));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User createLibrarian(User user) {
  //      user.setCreatedBy("ADMIN");
        user.setRole(roleService.getOne(2L));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User getByLogin(String login) {
        return repository.findUserByLoginAndDeletedFalse(login);
    }

    public boolean checkPassword(LoginDto loginDto) {
        return bCryptPasswordEncoder.matches(loginDto.getPassword(), getByLogin(loginDto.getLogin()).getPassword());
    }

    public Page<User> listAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void banUser(Long userId) {
        User user = getOne(userId);
 //       user.setDeleted(true);
  //      user.setDeletedWhen(LocalDateTime.now());
 //       user.setDeletedBy("ADMIN");
        update(user);
    }

    public void unbanUser(Long userId) {
        User user = getOne(userId);
    //    user.setDeleted(false);
    //    user.setDeletedWhen(LocalDateTime.now());
  //      user.setDeletedBy("ADMIN");
        update(user);
    }

  /*  public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }*/

    //TODO рассписать про генерацию ссылки
 /*   public void sendChangePasswordEmail(String email) {
        UUID uuid = UUID.randomUUID();
        User user = getUserByEmail(email);

        user.setChangePasswordToken(uuid.toString());
        update(user);
        SimpleMailMessage message = createMessage(email,
                "Восстановление пароля на сайте Онлайн Библиотека",
                "Добрый день. Вы получили это письмо, так как с вашего аккаунта была отправлена заявка <br> на восстановление пароля.\n "
                        + "Для восстановления пароля перейдите по ссылке: http://localhost:9090/users/change-password?uuid=" + uuid);
        javaMailSender.send(message);
    }

    private SimpleMailMessage createMessage(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        return message;
    }

    private User findByToken(String password) {
        return repository.findByChangePasswordToken(password);
    }

    public void changePassword(String uuid, String password) {
        User user = findByToken(uuid);
        user.setChangePasswordToken(null);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        update(user);
    }*/
}

