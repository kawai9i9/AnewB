package newb.c.backend.model.basemodel;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

public class User implements Serializable,Comparable<User> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * ID
     */
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Integer oid;

    private String username;
    
    @NotEmpty(message="不能为null")
    private String password;
    
    

    public User() {
		super();
	}

	public User(Integer oid, String username, String password) {
		super();
		this.oid = oid;
		this.username = username;
		this.password = password;
	}

	/**
     * 获取ID
     *
     * @return oid - ID
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * 设置ID
     *
     * @param oid ID
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public int compareTo(User o) {
		return this.getOid()-o.getOid();
	}

	@Override
	public String toString() {
		return "User["+oid+","+username+","+password+"]";
	}
    
	@SuppressWarnings("unused")
	private String invMen(String username,String password) {
		return "User["+username+","+password+"]";
	}
    
}