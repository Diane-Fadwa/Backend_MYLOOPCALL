package com.fadwa.myloopcall.service;

import com.fadwa.myloopcall.dto.AgentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AgentService {

    AgentDTO createAgent(AgentDTO agentDTO);

    AgentDTO updateAgent(Long id, AgentDTO agentDTO);

    AgentDTO getAgentById(Long id);

    List<AgentDTO> getAllAgents();

    Page<AgentDTO> getAllAgents(Pageable pageable);

    void deleteAgent(Long id);

    List<AgentDTO> getActiveAgents();

    List<AgentDTO> searchAgentsByNom(String nom);

    AgentDTO getAgentByNom(String nom);
}