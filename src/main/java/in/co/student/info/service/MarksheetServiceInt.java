package in.co.student.info.service;

import java.util.List;

import in.co.student.info.dto.MarksheetDTO;
import in.co.student.info.exception.DuplicateRecordException;


/**Marksheet Service Interface 
 * @author Navigable Set
 *@version 1.0
 *
 *@copywrite Navigable Set
 *
 */


public interface MarksheetServiceInt {


	/**
     * Add a Marksheet
     * 
     * @param dto
     * 
     * @throws DuplicateRecordException
     *             : throws when Marksheet already exists
     */
	
	
	public long add(MarksheetDTO dto) throws DuplicateRecordException;
	/**
     * Delete a Marksheet
     * 
     * @param dto
     
     */
	public void delete(MarksheetDTO dto) ;
	/**
     * Update a Marksheet
     * 
     * @param dto
     
     * @throws DuplicateRecordException
     *             : if updated Marksheet record is already exist
     */
	public void update(MarksheetDTO dto) throws DuplicateRecordException;
	   /**
     * Find Marksheet by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     *
     */
	public MarksheetDTO findByPK(long pk) ;
	
	
	/**
     * Finds Marksheet by Roll No
     * 
     * @param rollNo
     *            : get parameter
     * @return dto
     * @throws ApplicationException
     */
    public MarksheetDTO findByRollNo(String rollNo);
    
    
    
	 /**
    * Search Marksheet
    * 
    * @return list : List of Marksheet
    * @param dto
    *            : Search Parameters
    *
    */
	public List<MarksheetDTO> search(MarksheetDTO dto);
	 /**
    * Search Marksheet with pagination
    * 
    * @return list : List of Marksheet
    * @param dto
    *            : Search Parameters
    * @param pageNo
    *            : Current Page No.
    * @param pageSize
    *            : Size of Page
    * 
    */
	public List search(MarksheetDTO dto, int pageNo, int pageSize) ;
	
	public List getMeritList(int pageNo, int pageSize);
	
	
	public MarksheetDTO getMarkshet(String rollNo);
	
}
