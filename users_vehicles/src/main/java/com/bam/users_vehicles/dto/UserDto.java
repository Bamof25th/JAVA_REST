package com.bam.users_vehicles.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDto extends BaseDto {
    @NotBlank(message = "Please enter a name")
    private String uname;

    @Email(message = "please enter valid email")
    private String email;

    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid password format !!!")
    private String password;

    @NotBlank(message = "please enter your city")
    private String city;

    @NotBlank(message = "please enter your contact no")
    @Length(min = 10, max = 12, message = "please enter a 10 to 12 digit no")
    private String contactNo;

    @NotNull
    @Past(message = "Give Correct DOB")
    private LocalDate dob;
}
