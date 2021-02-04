package in.co.student.info.dao;

import java.util.List;

import in.co.student.info.dto.MarksheetDTO;




public interface MarksheetDAOInt {

	/**
	 * Adds a Marksheet.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(MarksheetDTO dto);

	/**
	 * Update a Marksheet.
	 * 
	 * @param dto
	 * 
	 */
	public void update(MarksheetDTO dto);

	/**
	 * Delete a Marksheet.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(MarksheetDTO dto);


    /**
     * Finds Marksheet by Roll No
     * 
     * @param rollNo
     *            : get parameter
     * @return dto
     * 
     */
    public MarksheetDTO findByRollNo(String rollNo);
    
    
    /**
	 * Find a Marksheet by it's pk.
	 * 
	 * @param id
	 * 
	 * @return MarksheetDTO
	 */
	public MarksheetDTO findByPk(long id);

	/**
	 * Search Marksheets with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto, long pageNo, int pageSize);

	/**
	 * Search Marksheets.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto);
	
	
	/**
	 * getMeritList Marksheets.
	 * 
	 * @param dto
	 * @return List
	 */
	public List getMeritList(int pageNo, int pageSize);
	
	/**
	 * Search getMarksheet.
	 * 
	 * @param dto
	 * @return List
	 */
	public MarksheetDTO getMarksheet(String rollNo);
	
}
