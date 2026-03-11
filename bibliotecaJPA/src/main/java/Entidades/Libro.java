/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author MoriTejo
 */
@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private int anioPublicacion;
    
   @ManyToOne
   @JoinColumn(name = "idAutor")
   private Autor autor;
   
   
   @ManyToMany
   @JoinTable(name = "libro_categoria", joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name = "idCategoria"))
   private Set<Categoria> categorias;

    public Libro() {
    }

    public Libro(Long id, String titulo, int anioPublicacion, Autor autor, Set<Categoria> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.categorias = categorias;
    }
   
   
    
    
   
   
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.libro[ id=" + id + " ]";
    }
    
}
