package com.obunda.cms.domain.asset;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.validator.constraints.UniqueElements;

import com.obunda.cms.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "tags")
public class Tag  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2233467589749052590L;

	@Column
	@UniqueElements
    private String title;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_tag",
    joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
    private Set<Post> posts;
}
