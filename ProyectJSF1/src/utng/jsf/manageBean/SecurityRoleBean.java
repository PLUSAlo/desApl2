package utng.jsf.manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import utng.jsf.entities.SecurityRole;
import utng.jsf.entities.User;
import utng.jsf.repositories.SecurityRoleRepository;
import utng.jsf.repositories.UserRepository;

@ManagedBean
public class SecurityRoleBean {

	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;
	private SecurityRole securityRole = new SecurityRole();
	private List<SecurityRole> securityRoles = null;

	public void save() {
		SecurityRoleRepository securityRoleRepository = new SecurityRoleRepository(entityManager);

		if (this.securityRole.getId() != null) {
			securityRoleRepository.update(this.securityRole);
		} else {
			securityRoleRepository.save(this.securityRole);
		}
		this.securityRole = new SecurityRole();
		this.securityRoles = null;

	}



	public void remove(SecurityRole securityRole) {
		SecurityRoleRepository securityRoleRepository = new SecurityRoleRepository(this.entityManager);
		securityRoleRepository.remove(securityRole);
		this.securityRoles = null;
	}

	//
	public void search(SecurityRole securityRole) {
		SecurityRoleRepository securityRoleRepository = new SecurityRoleRepository(this.entityManager);
		securityRole = securityRoleRepository.search(securityRole.getId());
		this.securityRole = securityRole;

	}

	public List<SecurityRole> getSecurityRoles() {
		if (this.securityRoles == null) {
			SecurityRoleRepository repository = new SecurityRoleRepository(entityManager);
			this.securityRoles = repository.getSecurityRoles();
		}
		return this.securityRoles;
	}

	public Long getCount() {
		SecurityRoleRepository repository= new SecurityRoleRepository(this.entityManager);
		return repository.getCountSecurityRoles();
	}
	
	public SecurityRole getSecurityRole() {
		return securityRole;
	}
	
	public void setSecurityRoleID(SecurityRole securityRole) {
		this.securityRole= securityRole;
	}
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("EntityManager");
	}

}
