package dtai.gp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
		@NamedQuery(name = "Agent.FINDALL", query = "select a from Agent a"),
		@NamedQuery(name = "Agent.FINDBYMAT", query = "select ag from Agent ag where ag.matricule=:mat"),
		@NamedQuery(name = "Agent.FINDBYMAIL", query = "select agt from Agent agt where agt.mailofficiel=:mail"),
		@NamedQuery(name = "Agent.FINDBYTEL", query = "select age from Agent age where age.telofficiel=:tel")
		})
public class Agent implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private String numrecrutement;
	private String situationmatrimonial;
	private int nombreenfant;
	private String titre;
	private int sexe;
	private int nationalite;
	private String adresseofficiel;
	@Size( min = 9, message = "Le numero de telephone doit contenir au moins 9 caractères" )
	private String telofficiel;
	@Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
	private String mailofficiel;

	
	@Temporal(TemporalType.DATE)
	private java.util.Date dateNaissance;
	private String lieuNaissance;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateRecrutement;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateRetraite;
	@ManyToOne
	private Corps corps;
	@ManyToOne
	private Service service;
	@OneToMany(mappedBy = "agent")
	private Set<DetailAbsence> absence = new HashSet<DetailAbsence>();
	@OneToMany(mappedBy = "agent")
	private Set<Affectation> affectation = new HashSet<Affectation>();
	@OneToMany(mappedBy = "agent")
	private Set<DetailDiplome> detaildiplome = new HashSet<DetailDiplome>();
	@OneToMany(mappedBy = "agent")
	private Set<DetailFormation> detailformation = new HashSet<DetailFormation>();
	@OneToMany(mappedBy = "agent")
	private Set<DetailSanction> detailsanction = new HashSet<DetailSanction>();
	@OneToMany(mappedBy = "agent")
	private Set<DetailFonction> detailfonction = new HashSet<DetailFonction>();
	@OneToMany(mappedBy = "agent")
	private Set<DetailClasse> detailclasse = new HashSet<DetailClasse>();
	@OneToMany(mappedBy = "agent")
	private Set<DetailCategorie> detailcategorie = new HashSet<DetailCategorie>();


	public Agent(String matricule, String nom, String prenom,
			String numrecrutement, String situationmatrimonial,
			int nombreenfant, String titre, int sexe, int nationalite,
			String adresseofficiel, String telofficiel, String mailofficiel,
			Date dateNaissance, String lieuNaissance, Date dateRecrutement,
			Date dateRetraite, Corps corps, Service service,
			Set<DetailAbsence> absence, Set<Affectation> affectation,
			Set<DetailDiplome> detaildiplome,
			Set<DetailFormation> detailformation,
			Set<DetailSanction> detailsanction,
			Set<DetailFonction> detailfonction, Set<DetailClasse> detailclasse,
			Set<DetailCategorie> detailcategorie) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.numrecrutement = numrecrutement;
		this.situationmatrimonial = situationmatrimonial;
		this.nombreenfant = nombreenfant;
		this.titre = titre;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.adresseofficiel = adresseofficiel;
		this.telofficiel = telofficiel;
		this.mailofficiel = mailofficiel;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.dateRecrutement = dateRecrutement;
		this.dateRetraite = dateRetraite;
		this.corps = corps;
		this.service = service;
		this.absence = absence;
		this.affectation = affectation;
		this.detaildiplome = detaildiplome;
		this.detailformation = detailformation;
		this.detailsanction = detailsanction;
		this.detailfonction = detailfonction;
		this.detailclasse = detailclasse;
		this.detailcategorie = detailcategorie;
	}

	public Agent() {
		super();
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumrecrutement() {
		return numrecrutement;
	}

	public void setNumrecrutement(String numrecrutement) {
		this.numrecrutement = numrecrutement;
	}

	public String getSituationmatrimonial() {
		return situationmatrimonial;
	}

	public void setSituationmatrimonial(String situationmatrimonial) {
		this.situationmatrimonial = situationmatrimonial;
	}

	public int getNombreenfant() {
		return nombreenfant;
	}

	public void setNombreenfant(int nombreenfant) {
		this.nombreenfant = nombreenfant;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public int getNationalite() {
		return nationalite;
	}

	public void setNationalite(int nationalite) {
		this.nationalite = nationalite;
	}

	public String getAdresseofficiel() {
		return adresseofficiel;
	}

	public void setAdresseofficiel(String adresseofficiel) {
		this.adresseofficiel = adresseofficiel;
	}

	public String getTelofficiel() {
		return telofficiel;
	}

	public void setTelofficiel(String telofficiel) {
		this.telofficiel = telofficiel;
	}

	public String getMailofficiel() {
		return mailofficiel;
	}

	public void setMailofficiel(String mailofficiel) {
		this.mailofficiel = mailofficiel;
	}

	public Corps getCorps() {
		return corps;
	}

	public void setCorps(Corps corps) {
		this.corps = corps;
	}

	public java.util.Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(java.util.Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public java.util.Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(java.util.Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public java.util.Date getDateRetraite() {
		return dateRetraite;
	}

	public void setDateRetraite(java.util.Date dateRetraite) {
		this.dateRetraite = dateRetraite;
	}

	public Set<Affectation> getAffectation() {
		return affectation;
	}

	public void setAffectation(Set<Affectation> affectation) {
		this.affectation = affectation;
	}

	public Set<DetailDiplome> getDetaildiplome() {
		return detaildiplome;
	}

	public void setDetaildiplome(Set<DetailDiplome> detaildiplome) {
		this.detaildiplome = detaildiplome;
	}

	public Set<DetailFormation> getDetailformation() {
		return detailformation;
	}

	public void setDetailformation(Set<DetailFormation> detailformation) {
		this.detailformation = detailformation;
	}

	public Set<DetailSanction> getDetailsanction() {
		return detailsanction;
	}

	public void setDetailsanction(Set<DetailSanction> detailsanction) {
		this.detailsanction = detailsanction;
	}

	public Set<DetailFonction> getDetailfonction() {
		return detailfonction;
	}

	public void setDetailfonction(Set<DetailFonction> detailfonction) {
		this.detailfonction = detailfonction;
	}

	public Set<DetailClasse> getDetailclasse() {
		return detailclasse;
	}

	public void setDetailclasse(Set<DetailClasse> detailclasse) {
		this.detailclasse = detailclasse;
	}

	public Set<DetailCategorie> getDetailcategorie() {
		return detailcategorie;
	}

	public void setDetailcategorie(Set<DetailCategorie> detailcategorie) {
		this.detailcategorie = detailcategorie;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Set<DetailAbsence> getAbsence() {
		return absence;
	}

	public void setAbsence(Set<DetailAbsence> absence) {
		this.absence = absence;
	}

	
	

}
