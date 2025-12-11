package com.fadwa.myloopcall.controller;

import com.fadwa.myloopcall.dto.AgentDTO;
import com.fadwa.myloopcall.service.AgentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.api.prefix}/agents")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class AgentController {

    private final AgentService agentService;

    @PostMapping
    public ResponseEntity<AgentDTO> createAgent(@Valid @RequestBody AgentDTO agentDTO) {
        log.info("REST request to create agent: {}", agentDTO.getNom());
        AgentDTO createdAgent = agentService.createAgent(agentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAgent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentDTO> updateAgent(
            @PathVariable Long id,
            @Valid @RequestBody AgentDTO agentDTO) {
        log.info("REST request to update agent with id: {}", id);
        AgentDTO updatedAgent = agentService.updateAgent(id, agentDTO);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentDTO> getAgentById(@PathVariable Long id) {
        log.info("REST request to get agent with id: {}", id);
        AgentDTO agent = agentService.getAgentById(id);
        return ResponseEntity.ok(agent);
    }

    @GetMapping
    public ResponseEntity<List<AgentDTO>> getAllAgents() {
        log.info("REST request to get all agents");
        List<AgentDTO> agents = agentService.getAllAgents();
        return ResponseEntity.ok(agents);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<AgentDTO>> getAllAgentsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(defaultValue = "nom") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("ASC")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<AgentDTO> agents = agentService.getAllAgents(pageable);

        return ResponseEntity.ok(agents);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        log.info("REST request to delete agent with id: {}", id);
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<AgentDTO>> getActiveAgents() {
        log.info("REST request to get active agents");
        List<AgentDTO> agents = agentService.getActiveAgents();
        return ResponseEntity.ok(agents);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AgentDTO>> searchAgents(@RequestParam String nom) {
        log.info("REST request to search agents by nom: {}", nom);
        List<AgentDTO> agents = agentService.searchAgentsByNom(nom);
        return ResponseEntity.ok(agents);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<AgentDTO> getAgentByNom(@PathVariable String nom) {
        log.info("REST request to get agent by nom: {}", nom);
        AgentDTO agent = agentService.getAgentByNom(nom);
        return ResponseEntity.ok(agent);
    }
}