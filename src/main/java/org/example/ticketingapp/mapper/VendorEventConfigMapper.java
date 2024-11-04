package org.example.ticketingapp.mapper;

import org.example.ticketingapp.configuration.cli.CliVendorEventConfig;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;
import org.example.ticketingapp.entity.VendorEventConfig;

public class VendorEventConfigMapper {

    public static VendorEventConfigDTO mapToVendorEventConfigDto(VendorEventConfig vendorEventConfig) {
        return new VendorEventConfigDTO(
                vendorEventConfig.getId(),
                vendorEventConfig.getEmail(),
                vendorEventConfig.getEventName(),
                vendorEventConfig.getTotalTickets(),
                vendorEventConfig.getTicketReleaseRate(),
                vendorEventConfig.getCustomerRetrievalRate(),
                vendorEventConfig.getMaxTicketCapacity()
        );
    }

    public static VendorEventConfig mapToVendorEventConfig(VendorEventConfigDTO vendorEventConfigDTO) {
        return new VendorEventConfig(
                vendorEventConfigDTO.getId(),
                vendorEventConfigDTO.getEmail(),
                vendorEventConfigDTO.getEventName(),
                vendorEventConfigDTO.getTotalTickets(),
                vendorEventConfigDTO.getTicketReleaseRate(),
                vendorEventConfigDTO.getCustomerRetrievalRate(),
                vendorEventConfigDTO.getMaxTicketCapacity()
        );
    }

    public static VendorEventConfigDTO mapFromInputSchema(
            CliVendorEventConfig cliVendorEventConfig,
            VendorEventConfigDTOIn vendorEventConfigDTOIn,
            String email) {

        return new VendorEventConfigDTO(
                vendorEventConfigDTOIn.getId(),
                email,
                vendorEventConfigDTOIn.getEventName(),
                cliVendorEventConfig.getTotalTickets(),
                cliVendorEventConfig.getTicketReleaseRate(),
                cliVendorEventConfig.getCustomerRetrievalRate(),
                cliVendorEventConfig.getMaxTicketCapacity()
        );
    }
}
