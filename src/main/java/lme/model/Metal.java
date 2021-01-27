package lme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "warehouse_table")
public class Metal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Column(name = "warehouse")
  private String warehouse;

  @NotNull
  @Column(name = "region")
  private String region;

  @NotNull
  @Column(name = "location")
  private String location;

  @NotNull
  @Column(name = "facility")
  private String facility;

  @NotNull
  @Column(name = "status")
  private String status;

  protected Metal() { }

  public Metal(String warehouse, String region, String location, String facility, String status) {
    this.warehouse = warehouse;
    this.region = region;
    this.location = location;
    this.facility = facility;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(String warehouse) {
    this.warehouse = warehouse;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getFacility() {
    return facility;
  }

  public void setFacility(String facility) {
    this.facility = facility;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Metal metal = (Metal) o;
    return id == metal.id && Objects.equals(region, metal.region) && Objects.equals(location, metal.location) && Objects.equals(facility, metal.facility) && Objects.equals(status, metal.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, region, location, facility, status);
  }

  @Override
  public String toString() {
    return "Metal{" +
            "id=" + id +
            ", region='" + region + '\'' +
            ", location='" + location + '\'' +
            ", facility='" + facility + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
