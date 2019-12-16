package com.mindtree.kalingahospital.service.serviceimpl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mindtree.kalingahospital.controller.sortBySalary;
import com.mindtree.kalingahospital.dto.DoctorDto;
import com.mindtree.kalingahospital.dto.PatientDto;
import com.mindtree.kalingahospital.entity.Doctor;
import com.mindtree.kalingahospital.entity.Patient;
import com.mindtree.kalingahospital.exceptions.serviceexcption.DoctorNotFoundException;
import com.mindtree.kalingahospital.exceptions.serviceexcption.KalingaHospitalServiceException;
import com.mindtree.kalingahospital.exceptions.serviceexcption.PatientsNotFoundException;
import com.mindtree.kalingahospital.repository.DoctorRepository;
import com.mindtree.kalingahospital.repository.PatientRepository;
import com.mindtree.kalingahospital.service.KalingaHospitalService;

@Service
public class KalingaHospitalServiceImpl implements KalingaHospitalService {

	@Autowired
	DoctorRepository doctorRepo;
	@Autowired
	PatientRepository patientRepo;

	@Autowired
	ModelMapper modelMapper;

	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

	@Override
	public PatientDto addPatient(Patient patient) throws KalingaHospitalServiceException{
		Set<Patient> patients = new HashSet<Patient>();
		patients.add(patient);
		PatientDto patientDto = new PatientDto();
		List<Doctor> doctors = doctorRepo.findAll();
		DoctorDto doctorDto = new DoctorDto();
		Optional<Doctor> d = doctorRepo.findByDoctorName(patient.getDoctor().getDoctorName());
		d.orElseThrow(()->new DoctorNotFoundException("no doctor with that name"));
		for (Doctor doc : doctors) {
			if (doc.getDoctorName().equals(patient.getDoctor().getDoctorName())) {

				doc.setSalary(doc.getSalary() + patient.getBillAmount());
				patient.setDoctor(doc);
				doctorDto = convertDoctorEntityToDto(doc);
				patient.getDoctor().setPatient(patients);

			}
		}

		patientRepo.save(patient);

		patientDto = convertPatientEntityToDto(patient);
		patientDto.setDoctorDto(doctorDto);
		return patientDto;
	}

	private DoctorDto convertDoctorEntityToDto(Doctor doctor) {
		return modelMapper.map(doctor, DoctorDto.class);
	}

	private Doctor convertDoctorDtoToEntity(DoctorDto doctorDto) {
		return modelMapper.map(doctorDto, Doctor.class);
	}

	private PatientDto convertPatientEntityToDto(Patient patient) {
		return modelMapper.map(patient, PatientDto.class);
	}

	private Patient convertPatientDtoToEntity(PatientDto patientDto) {
		return modelMapper.map(patientDto, Patient.class);
	}

	@Override
	public List<DoctorDto> sortDoctorBySalary() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors = doctorRepo.findAll();
		Collections.sort(doctors, new sortBySalary());
		List<DoctorDto> doctorDtos = doctors.stream().map(doctor -> convertDoctorEntityToDto(doctor))
				.collect(Collectors.toList());
		return doctorDtos;
	}

	@Override
	public List<DoctorDto> sortDoctorByPatientCount() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		for (Doctor d : doctorRepo.findAll()) {
			if (d.getPatient().size() >= 3) {
				doctors.add(d);
			}
		}
		Collections.sort(doctors);
		return doctors.stream().map(doctor -> convertDoctorEntityToDto(doctor)).collect(Collectors.toList());
	}

	@Override
	public String addToFile() throws KalingaHospitalServiceException {
		List<Patient> patients = patientRepo.findAll();
		if(patients.size()==0)
		{
			throw new PatientsNotFoundException("no patients are present...");
		}
		List<PatientDto> pdtos = new ArrayList<PatientDto>();
		for (Patient p : patients) {
			PatientDto pdto = new PatientDto();
			pdto.setPatientId(p.getPatientId());
			pdto.setPatientName(p.getPatientName());
			pdto.setBillAmount(p.getBillAmount());
			DoctorDto ddto = new DoctorDto();
			ddto.setDoctorId(p.getDoctor().getDoctorId());
			ddto.setDoctorName(p.getDoctor().getDoctorName());
			ddto.setYearOfExperience(p.getDoctor().getYearOfExperience());
			ddto.setSalary(p.getDoctor().getSalary());
			pdto.setDoctorDto(ddto);
			pdtos.add(pdto);
		}
		try {
			FileWriter fw = new FileWriter("Hospital.txt");
			for (PatientDto p : pdtos) {
				fw.write(p.getPatientId() + "-");
				fw.write(p.getPatientName() + "-");
				fw.write(p.getBillAmount() + "[" + "\n");
				fw.write(p.getDoctorDto().getDoctorId() + "-");
				fw.write(p.getDoctorDto().getDoctorName() + "-");
				fw.write(p.getDoctorDto().getSalary()+"-");
				fw.write(p.getDoctorDto().getYearOfExperience() + "\n" + "]");
			}

			fw.close();
			return "file added successfully";
		} catch (IOException e) {
			throw new KalingaHospitalServiceException("file is not written..........");
		}
	}

}
