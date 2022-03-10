package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "wizard_deposits")
public class WizardDeposit extends BaseEntity {

    @Column (name = "first_name", length = 50)
    private String firstName;

    @Column (name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column (columnDefinition = "TEXT")
    private String notes;

    @Column (nullable = false)
    private Integer age;

    @Column (name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column (name = "magic_wand_size")
    private Short magicWandSize;

    @Column (name = "deposit_group", length = 20)
    private String depositGroup;

    @Column (name = "deposit_start_date")
    private LocalDateTime depositStartDate;

    @Column (name = "deposit_amount")
    private BigDecimal depositAmount;

    @Column (name = "deposit_interest")
    private Float depositInterest;

    @Column (name = "deposit_charge")
    private Float depositCharge;

    @Column (name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;

    @Column (name = "is_deposit_expired")
    private Boolean isDepositExpired;

    public WizardDeposit() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Short getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(Short magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Float getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(Float depositInterest) {
        this.depositInterest = depositInterest;
    }

    public Float getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(Float depositCharge) {
        this.depositCharge = depositCharge;
    }

    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public Boolean getDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(Boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
