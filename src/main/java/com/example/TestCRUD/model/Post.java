package com.example.TestCRUD.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorId; // 작성자 아이디 - 이건 필요 없을 예정
    @Enumerated(EnumType.STRING)
    private PostType postType; // 게시글 유형 - 운전자, 탑승자, 택시팟
    private LocalDate date;  // 날짜
    private String departureLocation; // 출발 장소 -
    private String destinationLocation; // 도착 장소 -
    private String travelDescription; // 이동 설명
    private String driverRequirements; // 운전자 요구사항 - 이거는 bool로 변경해야 하나
    private int currentPassengers; // 현재 인원
    private int maxPassengers; // 최대 인원
    private String vehicleInfo; // 차량 정보

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getTravelDescription() {
        return travelDescription;
    }

    public void setTravelDescription(String travelDescription) {
        this.travelDescription = travelDescription;
    }

    public String getDriverRequirements() {
        return driverRequirements;
    }

    public void setDriverRequirements(String driverRequirements) {
        this.driverRequirements = driverRequirements;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public void setCurrentPassengers(int currentPassengers) {
        this.currentPassengers = currentPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
}
