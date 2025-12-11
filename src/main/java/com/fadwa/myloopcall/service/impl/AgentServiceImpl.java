package com.fadwa.myloopcall.service.impl;

import com.fadwa.myloopcall.dto.AgentDTO;
import com.fadwa.myloopcall.entity.AgentEntity;
import com.fadwa.myloopcall.exceptions.ResourceNotFoundException;
import com.fadwa.myloopcall.mapper.AgentMapper;
import com.fadwa.myloopcall.repository.AgentRepository;
import com.fadwa.myloopcall.service.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;

    @Override
    public AgentDTO createAgent(AgentDTO agentDTO) {
        log.info("Creating new agent: {}", agentDTO.getNom());

        if (agentRepository.existsByNom(agentDTO.getNom())) {
            throw new IllegalArgumentException("Un agent avec ce nom existe déjà");
        }

        AgentEntity agent = agentMapper.toEntity(agentDTO);
        AgentEntity savedAgent = agentRepository.save(agent);

        log.info("Agent created successfully with id: {}", savedAgent.getId());
        return agentMapper.toDTO(savedAgent);
    }

    @Override
    public AgentDTO updateAgent(Long id, AgentDTO agentDTO) {
        log.info("Updating agent with id: {}", id);

        AgentEntity existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));

        agentMapper.updateEntityFromDTO(agentDTO, existingAgent);
        AgentEntity updatedAgent = agentRepository.save(existingAgent);

        log.info("Agent updated successfully with id: {}", id);
        return agentMapper.toDTO(updatedAgent);
    }

    @Override
    @Transactional(readOnly = true)
    public AgentDTO getAgentById(Long id) {
        log.info("Fetching agent with id: {}", id);

        AgentEntity agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));

        return agentMapper.toDTO(agent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgentDTO> getAllAgents() {
        log.info("Fetching all agents");
        List<AgentEntity> agents = agentRepository.findAll();
        return agentMapper.toDTOList(agents);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AgentDTO> getAllAgents(Pageable pageable) {
        log.info("Fetching agents with pagination");
        Page<AgentEntity> agents = agentRepository.findAll(pageable);
        return agents.map(agentMapper::toDTO);
    }

    @Override
    public void deleteAgent(Long id) {
        log.info("Deleting agent with id: {}", id);

        if (!agentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agent not found with id: " + id);
        }

        agentRepository.deleteById(id);
        log.info("Agent deleted successfully with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgentDTO> getActiveAgents() {
        log.info("Fetching active agents");
        List<AgentEntity> agents = agentRepository.findByActif(true);
        return agentMapper.toDTOList(agents);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgentDTO> searchAgentsByNom(String nom) {
        log.info("Searching agents by nom: {}", nom);
        List<AgentEntity> agents = agentRepository.findByNomContainingIgnoreCase(nom);
        return agentMapper.toDTOList(agents);
    }

    @Override
    @Transactional(readOnly = true)
    public AgentDTO getAgentByNom(String nom) {
        log.info("Fetching agent by nom: {}", nom);

        AgentEntity agent = agentRepository.findByNom(nom)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with nom: " + nom));

        return agentMapper.toDTO(agent);
    }
}